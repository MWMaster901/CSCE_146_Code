/*
 * By Christopher Schweninger
 */
public class sheepScheduler 
{
	private MinHeap<sheep> sHeap;
	private sheep currentSheep;
	private int currentTime;
	private int totalSheep;
	//Initializer
	public sheepScheduler()
	{
		sHeap = new MinHeap<sheep>();
		currentSheep = new sheep();
		currentSheep = null;
		currentTime = 0;
		totalSheep = 0;
	}
	//Adds a new sheep to the heap (or active slot if heap & active slot is empty)
	public void addSheep(sheep aSheep)
	{
		if(currentSheep == null)
			this.currentSheep = aSheep;
		else
			sHeap.add(aSheep);
		totalSheep++;
	}
	//This advances the time forward one unit, rotating out the active sheep if their shearing is done
	public void advanceOneTimeUnit()
	{
		currentTime++;
		currentSheep.sheerForOneTimeUnit();
		if(currentSheep.isDone())
		{
			System.out.println(currentSheep);
			currentSheep = sHeap.remove();
		}
	}
	//This returns true if ALL sheep are done
	public boolean isDone()
	{
		if(currentSheep == null)
			return true;
		else
			return false;
	}
	//This returns the current sheep being sheared
	public sheep getCurrentSheep()
	{
		return currentSheep;
	}
}
