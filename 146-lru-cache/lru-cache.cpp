#include <unordered_map>

class LRUCache {
private:
    // Define the Doubly Linked List Node structure
    struct Node {
        int key;
        int value;
        Node* prev;
        Node* next;
        
        Node(int k, int v) : key(k), value(v), prev(nullptr), next(nullptr) {}
    };

    int capacity;
    std::unordered_map<int, Node*> cacheMap;
    Node* head;
    Node* tail;

    // Helper function to add a node right after the dummy head (MRU position)
    void addNode(Node* node) {
        node->next = head->next;
        node->prev = head;
        head->next->prev = node;
        head->next = node;
    }

    // Helper function to break links and remove a node from its current position
    void removeNode(Node* node) {
        Node* prevNode = node->prev;
        Node* nextNode = node->next;
        
        prevNode->next = nextNode;
        nextNode->prev = prevNode;
    }

    // Helper function to move an existing node to the head (Mark as Most Recently Used)
    void moveToHead(Node* node) {
        removeNode(node);
        addNode(node);
    }

public:
    LRUCache(int capacity) {
        this->capacity = capacity;
        
        // Initialize dummy head and tail
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        
        // Link them together initially
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        // If key doesn't exist, return -1
        if (cacheMap.find(key) == cacheMap.end()) {
            return -1;
        }
        
        // If key exists, get the node, refresh its position to head, and return value
        Node* node = cacheMap[key];
        moveToHead(node);
        return node->value;
    }
    
    void put(int key, int value) {
        // Case 1: Key already exists, update its value and move to head
        if (cacheMap.find(key) != cacheMap.end()) {
            Node* node = cacheMap[key];
            node->value = value;
            moveToHead(node);
        } 
        // Case 2: Key is new
        else {
            // If cache is at full capacity, evict the LRU node (just before dummy tail)
            if (cacheMap.size() == capacity) {
                Node* lruNode = tail->prev;
                
                // Remove from map and list
                cacheMap.erase(lruNode->key);
                removeNode(lruNode);
                
                delete lruNode; // Free memory
            }
            
            // Insert the new node into the map and add it right after dummy head
            Node* newNode = new Node(key, value);
            cacheMap[key] = newNode;
            addNode(newNode);
        }
    }
    
    // Destructor to clean up dynamically allocated memory
    ~LRUCache() {
        Node* curr = head;
        while (curr != nullptr) {
            Node* next = curr->next;
            delete curr;
            curr = next;
        }
    }
};