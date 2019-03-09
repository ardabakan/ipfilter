package ipfilter.rest;

import ipfilter.IPFilterRepository;
import ipfilter.model.Filter;
import ipfilter.service.FilterService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/ipfilters")
public class IPFilterRestService {

	@Autowired
	private IPFilterRepository ipFilterRepository;

	@Autowired
	private FilterService filterService;

	@RequestMapping(value = "/listFilters", method = RequestMethod.GET)
	public List<Filter> allAirports() {

		List result = ipFilterRepository.findAll();

		return result;
	}

	@RequestMapping(value = "/addFilter", method = RequestMethod.POST)
	public String addNewFilter(@RequestBody Filter filter) {

		Filter insertedFilter = ipFilterRepository.save(filter);

		String response = "";

		if (insertedFilter != null) {

			response = "" + insertedFilter.getId();

		} else {

			response = "Problem inserting filter";
		}

		return response;

	}

	@RequestMapping(value = "/checkFilter/{ipAddress}", method = RequestMethod.GET)
	public boolean checkIPFilter(@PathVariable("ipAddress") String ipAddress) {

		return filterService.checkIfBlackListed(ipAddress);

	}

	@RequestMapping(value = "/deleteFilter/{id}", method = RequestMethod.GET)
	public String deleteIPFilter(@PathVariable("id") Long id) {

		ipFilterRepository.deleteById(id);

		return "OK";

	}

}
