
public class Container extends Equipment {

	private static int nbInstances = 0;

	public Container(double volume, double mass)
	{
		super(volume, mass);
		this.setName("C-" + ++Container.nbInstances);
	}
}
