package ipfilter.service;

public interface FilterService {

	boolean checkIfBlackListed(String ipAddress);
}
