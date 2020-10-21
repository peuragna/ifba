package monitorsystem;

import java.util.Comparator;

public class OrderUnidadeByDistancia implements Comparator<UnidadeMonitora> {
	private float x;
	private float y;
	
	public OrderUnidadeByDistancia(float x, float y) {
		this.setX(x);
		this.setY(y);
		
	};
	
	
	public void setX(float x) {
		this.x = x;
	};


	public void setY(float y) {
		this.y = y;
	};

	@Override
	public int compare(UnidadeMonitora u1, UnidadeMonitora u2) {
		if(u1.getDistancia(x, y) > u2.getDistancia(x, y))
			  return 1;
			else if(u1.getDistancia(x, y) < u2.getDistancia(x, y))
			  return -1;
			else
			  return 0;	
	};
}
