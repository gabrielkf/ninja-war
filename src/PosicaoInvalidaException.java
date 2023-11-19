public class PosicaoInvalidaException extends Exception
{
	private static final long serialVersionUID = 1L;
	private static final String Message = "Posição Inválida!";

	public PosicaoInvalidaException()
	{
		super(Message);
	}
}
