package com.cloudmaturity.database.objects;

public class TeamNameResponse
{
    private boolean wasInDatabase;

    public TeamNameResponse(){}
    public TeamNameResponse(boolean wasInDatabase){ this.wasInDatabase = wasInDatabase; }

    public boolean getWasInDatabase(){ return wasInDatabase;}
}
