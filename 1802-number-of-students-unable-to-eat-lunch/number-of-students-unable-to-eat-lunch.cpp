class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        queue<int> q;
        int n = students.size();
        for(int i=0;i<n;i++){
            q.push(students[i]);
        }
        int cnt=0;
        for(int i=1;i<n*n && !q.empty() ;i++){
            int stud = q.front();
            q.pop();
            int sand = sandwiches[cnt];
            if(stud==sand){
                cnt++;
            }
            else{
                q.push(stud);
            }
        }
        return n-cnt;
    }
};