package ContaJava;
public class testeConta {
    public static void main(String []args){
        Conta novaConta=new Conta();
        novaConta.abrirConta("cc");
        novaConta.depositar(12);
        String inform;
        inform=novaConta.toString();
        System.out.println(inform);
    }
}
