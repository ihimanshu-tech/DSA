/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head==nullptr) return nullptr;
        
        Node* curr = head;
        while(curr!=nullptr){
            Node *newNode = new Node(curr->val);
            newNode->next = curr->next;
            curr->next = newNode;
            curr=newNode->next;
        }
        // Set the random pointers of the new nodes
        curr = head;
        while(curr!=nullptr){
            if(curr->random!=nullptr)
                curr->next->random = curr->random->next;
            curr = curr->next->next;
        }

        // Separate the new nodes from the original nodes
        curr = head;
        Node* clonedHead = head->next;
        Node* clone = clonedHead;
        while(clone->next !=nullptr){
            // Update the next nodes of original node and clone graph
            curr->next = curr->next->next;
            clone->next = clone->next->next;
            // Move pointers of original as well as cloned linked list to their next nodes
            curr = curr->next;
            clone = clone->next;
        }  
        curr->next = nullptr;
        clone->next = nullptr;

        return clonedHead; 
    }
};