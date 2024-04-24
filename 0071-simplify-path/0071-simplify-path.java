class Solution {
    public String simplifyPath(String path) {
        String[] lst = path.split("/");
        List<String> arry = new ArrayList<String>();
        for (String element: lst){
            if (element != ""){
                arry.add(element);
            }
        }
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i<arry.size(); i++){
            System.out.println(arry.get(i));
            if (arry.get(i).equals("..") && !stack.empty()){
                stack.pop();
            }else if (arry.get(i).equals(".") || arry.get(i).equals("..")){}
            else  {
                stack.push(arry.get(i));
            }
        }
        System.out.println(stack);
        StringBuffer str = new StringBuffer();
        if (stack.empty()){
            return "/";
        }
        while (!stack.empty()){
            str.insert(0,"/"+stack.pop());
        }
        return str.toString();
    }
}