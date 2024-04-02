package rs.edu.raf.BankService.bootstrap;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rs.edu.raf.BankService.data.dto.CreditRequestDto;
import rs.edu.raf.BankService.data.entities.*;
import rs.edu.raf.BankService.data.enums.AccountType;
import rs.edu.raf.BankService.data.enums.CreditRequestStatus;
import rs.edu.raf.BankService.data.enums.DomesticCurrencyAccountType;
import rs.edu.raf.BankService.repository.AccountRepository;
import rs.edu.raf.BankService.repository.credit.CreditRepository;
import rs.edu.raf.BankService.repository.credit.CreditRequestRepository;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    @Value("${MY_EMAIL_1}")
    private String myEmail1;

    @Value("${MY_EMAIL_2}")
    private String myEmail2;

    @Value("${MY_EMAIL_3}")
    private String myEmail3;

    @Value("${MY_EMAIL_4}")
    private String myEmail4;

    @Value("${MY_EMAIL_5}")
    private String myEmail5;

    private static final Logger logger = LoggerFactory.getLogger(BootstrapData.class);
    private final AccountRepository accountRepository;
    private final CreditRepository creditRepository;
    private final CreditRequestRepository creditRequestRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("BankService: DATA LOADING IN PROGRESS...");

        DomesticCurrencyAccount domesticCurrencyAccount1 = new DomesticCurrencyAccount();
        domesticCurrencyAccount1.setAccountNumber("3334444999999999");
        domesticCurrencyAccount1.setEmail(myEmail1);
        domesticCurrencyAccount1.setAccountType(AccountType.DOMESTIC_CURRENCY_ACCOUNT);
        domesticCurrencyAccount1.setEmployeeId(2L);
        domesticCurrencyAccount1.setMaintenanceFee(220.00);
        domesticCurrencyAccount1.setCurrencyCode("RSD");
        domesticCurrencyAccount1.setDomesticCurrencyAccountType(DomesticCurrencyAccountType.RETIREMENT);
        domesticCurrencyAccount1.setInterestRate(2.5);
        accountRepository.save((Account) domesticCurrencyAccount1);

        DomesticCurrencyAccount domesticCurrencyAccount2 = new DomesticCurrencyAccount();
        domesticCurrencyAccount2.setAccountNumber("3334444111111111");
        domesticCurrencyAccount2.setEmail(myEmail2);
        domesticCurrencyAccount2.setAccountType(AccountType.DOMESTIC_CURRENCY_ACCOUNT);
        domesticCurrencyAccount2.setEmployeeId(2L);
        domesticCurrencyAccount2.setMaintenanceFee(220.00);
        domesticCurrencyAccount2.setCurrencyCode("RSD");
        domesticCurrencyAccount2.setDomesticCurrencyAccountType(DomesticCurrencyAccountType.RETIREMENT);
        domesticCurrencyAccount2.setInterestRate(2.5);

        ForeignCurrencyAccount foreignCurrencyAccount1 = new ForeignCurrencyAccount();
        foreignCurrencyAccount1.setAccountNumber("3334444777777777");
        foreignCurrencyAccount1.setEmail(myEmail3);
        foreignCurrencyAccount1.setAccountType(AccountType.FOREIGN_CURRENCY_ACCOUNT);
        foreignCurrencyAccount1.setEmployeeId(2L);
        foreignCurrencyAccount1.setMaintenanceFee(220.00);
        foreignCurrencyAccount1.setCurrencyCode("USD");
        accountRepository.saveAndFlush(foreignCurrencyAccount1);

        Credit c = new Credit();
        c.setAccountNumber("3334444111111111");
        c.setCreditNumber(1L);
        c.setCreditAmount(36000.0);
        c.setCreditCreationDate(new Date().getTime());
        c.setCreditExpirationDate(new Date().getTime() + 1000L * 60 * 60 * 24 * 365);
        c.setCreditName("stambeni");
        c.setInstallmentAmount(100.0);
        c.setCurrencyCode("EUR");
        c.setEffectiveInterestRate(3.5);
        c.setNominalInterestRate(3.0);
        c.setNextInstallmentDate(new Date().getTime() + 1000L * 60 * 60 * 24 * 30);
        c.setPaymentPeriodMonths(12L);
        c.setRemainingAmount(36000.0);
        creditRepository.save(c);

        CreditRequest crd = new CreditRequest();
        crd.setAccountNumber("3334444111111111");
        crd.setCreditAmount(36000.0);
        crd.setCreditPurpose("stambeni");
        crd.setCurrency("EUR");
        crd.setEducationLevel("srednja");
        crd.setEmploymentPeriod(5L);
        crd.setHousingStatus("iznajmljen");
        crd.setMaritalStatus("neozenjen");
        crd.setMobileNumber("0655555555");
        crd.setMonthlySalary(1000L);
        crd.setPermanentEmployment(true);
        crd.setOwnCar(false);
        crd.setBranch("Novi Sad");
        crd.setMaturity(12L);
        crd.setCreditType("stambeni");
        crd.setStatus(CreditRequestStatus.APPROVED);
        crd.setNote("pls daj kredit");
        creditRequestRepository.save(crd);

        logger.info("BankService: DATA LOADING IN PROGRESS...");
    }
}
