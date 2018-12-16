public class RankTile extends Tile{
	protected int rank;
	
	public RankTile(int rank) {
		this.rank = rank;
		
	}
	@Override
	public boolean matches(Tile other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (this.getClass() != other.getClass()) {
			return false;
		}
		
	
		RankTile a = (RankTile)other;

		return (super.matches(other) && rank == a.rank);
	}
	
}