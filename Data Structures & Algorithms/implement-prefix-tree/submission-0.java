class PrefixTree {

    char val;
    PrefixTree[] child=new PrefixTree[26];
    boolean isEnd;

    public PrefixTree() {
    }

    public void insert(String word) {
        int i=0;
        ijk(word,this,i);
    }
    public void ijk(String word,PrefixTree root,int i){
        if(i==word.length()){root.isEnd=true;return;}
        char c=word.charAt(i);
        int index=c-'a';
        if(root.child[index]==null){
            root.child[index]=new PrefixTree();
            root.child[index].val=c;
        }
        i++;
        ijk(word,root.child[index],i);
    }

    public boolean search(String word) {
        int i=0;
        boolean xyz=sh(word,this,i);
        return xyz;
    }

    public boolean sh(String word,PrefixTree root,int i){
        if(i==word.length()){return root.isEnd;}
        char c=word.charAt(i);
        int index=c-'a';
        if(root.child[index] != null && root.child[index].val==c){
            i++;
            return sh(word,root.child[index],i);
        }
        else{
            return false;
        }
        //return true;
    }

    public boolean startsWith(String prefix) {
        int i=0;
        boolean xyz=shi(prefix,this,i);
        return xyz;
    }
    public boolean shi(String word,PrefixTree root,int i){
        if(i==word.length()){return true;}
        char c=word.charAt(i);
        int index=c-'a';
        if(root.child[index] != null && root.child[index].val==c){
            i++;
            return shi(word,root.child[index],i);
        }
        else{
            return false;
        }
        //return true;
    }
}
