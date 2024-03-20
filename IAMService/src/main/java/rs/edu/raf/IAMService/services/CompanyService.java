package rs.edu.raf.IAMService.services;

import org.springframework.stereotype.Service;
import rs.edu.raf.IAMService.data.dto.CompanyDto;

import java.util.List;
import java.util.Optional;

@Service
public interface CompanyService {
    void deleteCompanyByRegistryNumber(String registrationNumber);

    CompanyDto getCompanyById(Long id);

    CompanyDto createCompany(CompanyDto companyDto);

    List<CompanyDto> findAllCompanies();
}
