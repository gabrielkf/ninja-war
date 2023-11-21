public class PosicaoInvalidaException extends Exception
{
	private static final String Message = "Posição Inválida!";

	public PosicaoInvalidaException()
	{
		super(Message);
	}
}
