package webservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Calculadora {

    private String operador;
    private int operando1;
    private int operando2;
    private int resultado;
    private String erro;

    public Calculadora() 
    {
    }

    public Calculadora(int op1, int op2, String oper) 
    {
        this.operando1 = op1;
        this.operando2 = op2;
        this.operador = oper;
        this.erro = "";
        this.resultado = 0;
        if (oper == "+")
            this.resultado = op1 + op2;
        else if (oper == "*")
            this.resultado = op1 * op2;
        else
            this.erro = "Operação não suportada!";
    }

    public void setOperando1(int op1) {
        this.operando1 = op1;
    }

    public void setOperando2(int op2) {
        this.operando2 = op2;
    }

    public void setOperador(String opr) {
        this.operador = opr;
    }

    public void setResultado(int res) {
        this.resultado = res;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public int getOperando1() {
        return this.operando1;
    }

    public int getOperando2() {
        return this.operando2;
    }

    public int getResultado() {
        return this.resultado;
    }

    public String getOperador() {
        return this.operador;
    }

    public String getErro() {
        return this.erro;
    }
}
