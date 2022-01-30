package com.n11.graduationproject.mapper;

import com.n11.graduationproject.dto.response.LoanResultDto;
import com.n11.graduationproject.model.LoanResult;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface LoanResultMapper {
    LoanResultMapper INSTANCE = Mappers.getMapper(LoanResultMapper.class);

    List<LoanResultDto> mapFromLoanResultListToLoanResultDto(List<LoanResult> loanResult);

    LoanResultDto mapFromLoanResultToLoanResultDto(LoanResult loanResult);

    LoanResult mapFromLoanResultDtoToLoanResult(LoanResultDto loanResultDto);
}
