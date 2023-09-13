package com.hoanglong.backendecommercerestapi.user.mapper;

import com.hoanglong.backendecommercerestapi.user.dto.AddressDto;
import com.hoanglong.backendecommercerestapi.user.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDto ConvertToAddressDto(Address address);
    List<AddressDto> ConvertToListAddressDto(List<Address> addressList);

    Address convertToAddress (AddressDto addressDto);

    List<Address> convertToAddressList(List<AddressDto> addressDtos);

}
