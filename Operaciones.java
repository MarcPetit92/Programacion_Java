/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuari
 */
public class Operaciones

{
	//declaramos los atributos
	private int operando1;
	private int operando2;

	//hora viene el constructor vacio
	public Operaciones()
	{
	}
	//luego el constructor con un atributo
	public Operaciones(int op1)
	{
		this.operando1 = op1;
	}
	//y por ultimo el constructor con los dos atributos
	public Operaciones(int op1, int op2)
	{
			this.operando1 = op1;
			this.operando2 = op2;
	}
//ahora hay que hacer los metodos de acceso primero los getters y luego los setters
//vamos a source añadir codigo, getters (para recuperar) y setters(para meter) de los dos atributos

    public int getOperando1() {
        return operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }
        
        
	
		public int suma(int op1, int op2)

		{
			int resultado=op1+op2;
			return resultado;
		}

			public int resta(int op1, int op2)

		{
			int resultado=op1-op2;
			return resultado;
		}

			public int multiplicar(int op1, int op2)

		{
			int resultado=op1*op2;
			return resultado;
		}

		

	}	

