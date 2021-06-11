/**
 *  Validar se tem alguma linha incorreta no ficheiro
 */
public class LinhaIncorretaException extends Throwable {
    public LinhaIncorretaException(){
        super();
    }

    public LinhaIncorretaException(String s){
        super(s);
    }
}
