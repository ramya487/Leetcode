/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/
class Solution {
public:
    Node* connect(Node* root) {
    if(root==NULL)
    return NULL;
    queue<Node*>q;
    q.push(root);
    q.push(NULL);
    while(q.size()>1)
    {
        int size=q.size();
        for(int i=0;i<size;i++)
        {
            Node* node=q.front();
            q.pop();
            if(node==NULL)
            {
                q.push(NULL);
                continue;
            }
            if(node->left)
            q.push(node->left);
            if(node->right)
            q.push(node->right);

            node->next=q.front();
        }
    }
    return root;
    }
};