package models.entity;

import java.util.UUID;

/**
 * This class allows objects to be uniquely identified. 
 * @author  wadeanderson
 */
public class UniqueEntity implements Serializable {

	private final UUID _id;

	/**
	 * Constructs a UniqueEntity whose UUID is <code>id</code>. 
	 * If <code>id</code> is <code>null </code>, a new UUID is generated. 
	 * @param id the UUID
	 */
	protected UniqueEntity (UUID id) {
		assert (true);

		_id = (id != null ? id : UUID.randomUUID()); 
	}

	/**
	 * Returns the UUID of <code>this</code>.
	 * @return
	 */
	public UUID getId() {
		assert(true);
		
		return _id;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof UniqueEntity)) {
			throw new ClassCastException();
		}
		return _id.equals(((UniqueEntity)o)._id);
	}
	
	@Override
	public int hashCode() {
		return _id.hashCode();
	}

}