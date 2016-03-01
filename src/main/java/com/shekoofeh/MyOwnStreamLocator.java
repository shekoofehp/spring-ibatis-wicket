package com.shekoofeh;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.UrlResourceStream;
import org.apache.wicket.util.resource.locator.ResourceStreamLocator;
import org.apache.wicket.util.string.Strings;

public class MyOwnStreamLocator extends ResourceStreamLocator
{
	@Override
	public IResourceStream locate(Class<?> clazz, String path)
	{
		
		String location;
		
		String extension = path.substring(path.lastIndexOf('.') + 1);
		String simpleFileName = Strings.lastPathComponent(clazz.getName(), '.');
		location = "/pages/" + simpleFileName + "." + extension;
		
		URL url;
		try
		{
			// try to load the resource from the web context
			url = WebApplication.get().getServletContext().getResource(location);
			
			if (url != null)
			{
				return new UrlResourceStream(url);
			}
		}
		catch (MalformedURLException e)
		{
			throw new WicketRuntimeException(e);
		}

		// resource not found; fall back on class loading
		return super.locate(clazz, path);
	}

}