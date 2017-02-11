
public class Container extends Equipment {

	private static int instanceNbr=0;

	public Container(double volume, double mass)
	{
		super(volume, mass);
		this.name="C-" + ++Container.instanceNbr;
	}
}
