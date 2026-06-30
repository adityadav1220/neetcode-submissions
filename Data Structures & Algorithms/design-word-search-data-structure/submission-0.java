class WordDictionary {

    WordDictionary[] children = new WordDictionary[26];
    boolean isEnd;

    public WordDictionary() {
        return;
    }

    public void addWord(String word) {
        WordDictionary root = this;
        int j=word.length();
        int i=0;
        while(i<j){
            char c=word.charAt(i);
            int index=c-'a';

            if(root.children[index]==null){
                root.children[index]=new WordDictionary();
            }
            root=root.children[index];
            i++;
        }
        root.isEnd=true;
        return;
    }

    public boolean search(String word) {
        WordDictionary root = this;
        int i=0;
        





        return s(word,root,i);
    }

    public boolean s(String word,WordDictionary root,int i){
        if(i==word.length()){return root.isEnd;}
        char c=word.charAt(i);
        if(c=='.'){
            for(int j=0;j<=25;j++){
                if(root.children[j]!=null){
                    if(s(word,root.children[j],i+1)){return true;}
                }
            }
            return false;
        }
        else{
            int index=c-'a';
            if(root.children[index]==null){return false;}
            else{
                return s(word,root.children[index],i+1);
            }
        }

    }
}
