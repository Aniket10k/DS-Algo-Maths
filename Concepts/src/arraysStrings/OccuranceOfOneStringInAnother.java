package arraysStrings;

public class OccuranceOfOneStringInAnother {
	int strstr(String s, String x)
    {
        int t = 0;
        int i = 0;
        for(;i<s.length();i++){
            if(t==x.length()){
                break;
            }
            if(s.charAt(i)==x.charAt(t)){
                t++;
            } else{
                t=0;
            }
        }
        return t==x.length() ? i-t : -1; 
    }
}
