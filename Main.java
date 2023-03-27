public class Main {
    
    public static final int ERROR = 0;
    public static final int D1 = 11;
    public static final int D2 = 12;
    public static final int E1 = 21;
    public static final int E2 = 22;

    public static void main(String[] args) {
        Main programa = new Main();
        System.out.println(programa.categoria("valido2", 11, "+"));
        System.out.println(programa.categoria("valido2", 11, "-"));
        System.out.println(programa.categoria("valido2", 12, "+"));
        System.out.println(programa.categoria("valido2", 12, "-"));
        System.out.println(programa.categoria("novalido", -1, "a+"));
    }
    
    public int categoria(String codigoEmpleado, int mesesTrabajado, String directivo) {
        int minus=0, digito=0;
        if(codigoEmpleado==null || directivo==null || mesesTrabajado<0 || mesesTrabajado>999){
            return ERROR;
        }else{
            for(int i=0; i<codigoEmpleado.length();i++){
                if(!Character.isLowerCase(codigoEmpleado.charAt(i)) || !Character.isDigit(codigoEmpleado.charAt(i))){
                    if(Character.isLowerCase(codigoEmpleado.charAt(i))){
                        minus++;                
                    }
                    if(Character.isDigit(codigoEmpleado.charAt(i))){
                        digito++;
                    }
                    if(minus>0 && digito>0){
                        if(directivo=="+"){
                            if(mesesTrabajado>=12){
                                return D1;
                            }else{
                                return D2;
                            }
                        }
                        if(directivo=="-"){
                            if(mesesTrabajado>=12){
                                return E1;
                            }else{
                                return E2;
                            }
                        }
                    }
                }
            }
        }
        return ERROR;
    }
}