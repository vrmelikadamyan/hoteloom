package com.vmelik.hotel.service.impl;

import com.vmelik.hotel.exception.HotelNotFoundException;
import com.vmelik.hotel.model.entity.Hotel;
import com.vmelik.hotel.model.entity.HotelContact;
import com.vmelik.hotel.model.entity.HotelContactType;
import com.vmelik.hotel.model.request.AddHotelContactRequest;
import com.vmelik.hotel.model.request.UpdateHotelContactRequest;
import com.vmelik.hotel.repository.HotelContactRepository;
import com.vmelik.hotel.service.HotelContactService;
import com.vmelik.hotel.service.HotelContactTypeService;
import com.vmelik.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelContactServiceImpl implements HotelContactService {
    private final HotelService hotelService;
    private final HotelContactTypeService hotelContactTypeService;
    private final HotelContactRepository hotelContactRepository;

    @Override
    @Transactional
    public HotelContact addContact(AddHotelContactRequest hotelContact) {
        Hotel hotel = hotelService.findHotel(hotelContact.getHotelId());
        HotelContactType contactType = hotelContactTypeService.findContactType(hotelContact.getContactType());

        HotelContact contact = new HotelContact();
        contact.setHotel(hotel);
        contact.setContactType(contactType);
        contact.setValue(hotelContact.getValue());

        return hotelContactRepository.save(contact);
    }

    @Override
    public HotelContact findContact(UUID contactId) {
        return hotelContactRepository.findById(contactId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel contact with id = %s not found!".formatted(contactId)));
    }

    @Override
    @Transactional
    public HotelContact updateContact(UUID contactId, UpdateHotelContactRequest hotelContact) {
        HotelContact contact = findContact(contactId);
        HotelContactType contactType = hotelContactTypeService.findContactType(hotelContact.getContactType());
        contact.setContactType(contactType);
        contact.setValue(hotelContact.getValue());

        return hotelContactRepository.save(contact);
    }

    @Override
    @Transactional
    public HotelContact deleteContact(UUID contactId) {
        HotelContact contact = findContact(contactId);
        hotelContactRepository.delete(contact);

        return contact;
    }
}
