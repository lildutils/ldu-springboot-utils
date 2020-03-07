package com.lildutils.springboot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LDuObjectMapperUtil
{
	public static <T> T buildDTO( Long id, Class<T> clazz )
	{
		try
		{
			return (T) new ObjectMapper().readValue( "{\"id\": " + String.valueOf( id ) + "}", clazz );
		}
		catch( Exception e )
		{
			return null;
		}
	}

	public static <T> T buildDTO( Class<T> clazz, String... params )
	{
		try
		{
			String json = "{";
			boolean odd = false;
			boolean even = true;
			for( String p : params )
			{
				json += "\"" + p + "\"";
				if( even )
				{
					json += ":";
					even = false;
					odd = true;
				}
				else if( odd )
				{
					json += ",";
					even = true;
					odd = false;
				}
			}
			json = json.substring( 0, json.length() - 1 );
			json += "}";
			return new ObjectMapper().readValue( json, clazz );
		}
		catch( Exception e )
		{
			return null;
		}
	}

}
