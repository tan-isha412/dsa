class Solution {
    public int calculate(String s) {
        Map<Character,Integer> m=new HashMap<>();
        m.put('+',0);
        m.put('-',0);
        m.put('*',1);
        m.put('/',1);
        ArrayDeque<Integer> numst=new ArrayDeque<>();
        ArrayDeque<Character> oprst=new ArrayDeque<>();
        int n=0;
        boolean innum=false;
        s=s.trim();
        for(char ch:s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                n = n * 10 + (ch-'0');
                innum=true;
            }
            else
            {
                if(innum) 
                {
                    numst.push(n);
                    n=0;
                    innum=false;
                }
                if(ch==' ') continue;
                while(!oprst.isEmpty() &&  m.get(oprst.peek())>=m.get(ch))
                {
                    int op2=numst.pop(),op1=numst.pop();
                    char opr=oprst.pop();
                    if(opr=='*') numst.push(op1*op2);
                    else if(opr=='/') numst.push(op1/op2);
                    else if(opr=='+') numst.push(op1+op2);
                    else numst.push(op1-op2);
                }
                oprst.push(ch);
            }
        }
        if(innum) numst.push(n);
        while(!oprst.isEmpty())
        {
            int op2=numst.pop(),op1=numst.pop();
            char c=oprst.pop();
            if(c=='+') numst.push(op1+op2);
            else if(c=='-') numst.push(op1-op2);
            else if(c=='*') numst.push(op1*op2);
            else numst.push(op1/op2);
        }
        return numst.pop();
    }
}