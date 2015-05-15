package com.carlgira.hz.oi;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class to view all the objects in the datagrid of Hazelcast
 * @author carlgira
 */
public class HazelcastObjectInspector 
{

    public static void main(String args[]) throws InterruptedException 
    {   
        final HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        
        
        final Collection distributedObjects = new ArrayList();
        distributedObjects.addAll(hz.getDistributedObjects());
        
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() 
            {
                while(true)
                {
                    try 
                    {
                        Thread.sleep(5000);
                    } 
                    catch (InterruptedException ex) 
                    {}
                    distributedObjects.clear();
                    distributedObjects.addAll(hz.getDistributedObjects());
                }
            }
        });
       inspectorjay.InspectorJay.inspect(distributedObjects);
        
        thread.start();
    }
}