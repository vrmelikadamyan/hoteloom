package com.vmelik.hotel.service;

import com.vmelik.hotel.model.entity.HotelContact;
import com.vmelik.hotel.model.request.AddHotelContactRequest;
import com.vmelik.hotel.model.request.UpdateHotelContactRequest;

import java.util.UUID;

public interface HotelContactService {

    HotelContact addContact(AddHotelContactRequest hotelContact);

    HotelContact findContact(UUID contactId);

    HotelContact updateContact(UUID contactId, UpdateHotelContactRequest hotelContact);

    HotelContact deleteContact(UUID contactId);
}
