class Solution {
    public int evalRPN(String[] tokens) {
        int res=0;
        Stack<Integer> st=new Stack<>();
        int i=0;

        while(i<tokens.length){
            String temp=tokens[i];

            char c=temp.charAt(0);
            if((c=='+'|| c=='-'|| c=='*'|| c=='/')&&temp.length()==1){
                                    // System.out.println(temp);
                int t2=st.pop();
                                // System.out.println(t2);
                int t1=st.pop();
                                    // System.out.println(t1);
                    
                    if(c=='+'){
                        res=t1+t2;
                    }
                    else if(c=='-'){
                        res=t1-t2;
                    }
                    else if(c=='*'){
                        res=t1*t2;
                    }
                    else if(c=='/'){
                        res=t1/t2;
                    }
                    st.push(res);
                                    // System.out.println("Putting back in stack "+res);
                
            }
            else{
                if(temp.length()>1){
                    String y = "";
                    int j = 0;
                    while (j < temp.length()) {
                        char a = temp.charAt(j);
                        y = y + a;
                        j++;
                    }
                    int x = Integer.parseInt(y);
                    st.push(x);
                                    // System.out.println("Length was greater than 1 so "+x);
                }
                else{
                    int x = c - '0';
                    st.push(x);
                                    // System.out.println("Normal number detected "+x);
                }

            }
            i++;
        }
        return st.peek();
    }
}
