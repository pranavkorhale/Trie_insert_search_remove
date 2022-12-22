
public class Main
{
    public static class TreeNode{
        char data;
        TreeNode[] arr;
        boolean flag;
        public TreeNode(char ch){
            data = ch;
            arr = new TreeNode[26];
            for(int i=0;i<arr.length;i++){
                arr[i] = null;
            }
            flag = false;
        }
    }
    public static TreeNode root = new TreeNode('\0');
    
    //Insert function : recursive way
    
    public static void insert_function(String str,TreeNode curr){
        if(str.length()==0)
        {
            curr.flag = true;
            return;
        }
        
        char ch = str.charAt(0);
        int index = ch-'a';
        
        if(curr.arr[index]==null){
            TreeNode temp = new TreeNode(ch);
            curr.arr[index] = temp;
            curr = curr.arr[index];
        }
        else if(curr.arr[index]!=null){
            curr = curr.arr[index];
        }
        insert_function(str.substring(1),curr);
    }
    
    
    public static void insert(String str){
        TreeNode curr = root;
        insert_function(str,curr);
    }
    
    
    
    //Search function : Iterative Way
    public static boolean search_Function(String str){
        TreeNode curr = root;
        int n = str.length();
        int i = 0;
        for(i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int index = ch-'a';
            if(curr.arr[index]==null){
                return false;
            }
            else{
                curr = curr.arr[index];
            }
        }
        return curr.flag;
        
        
    }
    
    //Remove function
    public static void remove(String str){ 
        TreeNode curr = root;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int index = ch-'a';
            curr = curr.arr[index];
        }
        curr.flag=false;
        
    }
 
    
	public static void main(String[] args) {
	    insert("abababa");
	    insert("ababa");
	    insert("ab");
	    insert("aba");
	    insert("abdbdbdbdbd");
	    boolean result = search_Function("abdbdbdbdbd");
	    System.out.println(result);
	    remove("abdbdbdbdbd");
	    System.out.println(search_Function("abdbdbdbdbd"));
	    
	}
}
