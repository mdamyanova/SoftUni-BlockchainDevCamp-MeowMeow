public class ContractService {
    private Web3j web3j;
    private Credentials credentials;
    private MeowToken contract;

    public ContractService(String provider, String privateKey) throws Exception {
        this.web3j = Web3j.build(new HttpService(provider));
        this.credentials = Credentials.create(privateKey);
    }
}