package ipfilter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Filter {

	public Filter() {

		super();

	}

	public Filter(String filterContent) {
		super();
		this.filterContent = filterContent;
	}
	
	public Filter(Long id, String filterContent) {
		super();
		this.id = id;
		this.filterContent = filterContent;
	}

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilterContent() {
		return filterContent;
	}

	public void setFilterContent(String filterContent) {
		this.filterContent = filterContent;
	}

	@Override
	public String toString() {

		return String.format("IPFilter [id=%s, filterContent=%s]", id,
				filterContent);

	}

	private String filterContent;

}
