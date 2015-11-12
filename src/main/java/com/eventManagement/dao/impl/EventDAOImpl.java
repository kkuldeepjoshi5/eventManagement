/*package com.eventManagement.dao.impl;


import java.io.BufferedOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.eventManagement.dao.EventDAO;
import com.eventManagement.entity.Event;
import com.eventManagement.utility.Message;


public class EventDAOImpl extends AbstractDAOImpl<Event> implements EventDAO {

    @Override
    public Message insert(Event event) {
        return super.insert(event);
    }

    @Override
    public Message delete(Long eventId) {
        return super.delete(eventId);
    }

    @Override
    public List<Event> getAll() {
        return super.getAll();
    }

    @Override
    public Event getById(Long eventId) {
        return super.getById(eventId);
    }

    @Override
    public Message update(Event event) {
        return super.update(event);
    }

    @Override
    protected Event mapper(ResultSet resultSet) {

        Event event=new Event();
    //    Image image=new Image();
        try {
            event.setId(resultSet.getLong(1));
            event.setTitle(resultSet.getString(2));
            event.setDescription(resultSet.getString(3));
       //     image.setUrl(resultSet.getString(5));
        //	event.setPhoto(image);
            System.out.println("photo::"+event.getPhotoUrl());

        } catch (SQLException e) {

            e.printStackTrace();
        }


        return event;
    }



    @Override
    protected CallableStatement createQuery(String call, Event event) {
        String query = null;
        switch (call) {

        case "update":
            query = "{call updateEvent()}";

            try {
                stmt = getConnection().prepareCall(query);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();

            }
            break;
        case "delete":
            query = "{call deleteEvent(" + event.getId() + ")}";

            try {
                System.out.println(" in exception :");
                stmt = getConnection().prepareCall(query);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();

            }
            break;
        case "insert":

            query = "{call insertEvent('" + event.getTitle() + "','"
                    + event.getDescription() + "','" + event.getFromDate()+"','"+null+"','"+null+"')}";
                    + "','" + event.getPhoto().getEventPhoto().getOriginalFilename() + "','"+event.getPhoto().getPhotoDir()+"')}";
            System.out.println("query=" + query);
            try {
                System.out.println(getConnection());
                stmt = getConnection().prepareCall(query);

                System.out.println(" stmt: " + stmt);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();

            }
            break;

        case "getAll":
            query = "{call getAllEvent()}";

            try {
                stmt = getConnection().prepareCall(query);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();

            }
            break;

        }
        return stmt;
    }

    @Override
    protected void saveImage(Event event) throws IOException {

         BufferedOutputStream stream=null;
        	stream = new BufferedOutputStream( new FileOutputStream(event.getPhoto().getPhotoDir()));
             stream.write(event.getPhoto().getEventPhoto().getBytes());
         stream.close();
    }

	@Override
	public Message remove(Long id, Class<Event> tempClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event getById(Long id, Class<Event> tempClass) {
		// TODO Auto-generated method stub
		return null;
	}





}
*/