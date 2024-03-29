package ru.infoza.resourceServer;

public class ResourceServerController implements ResourceServerControllerMBean {
    private final ResourceServerI resourceServer;

    public ResourceServerController(ResourceServerI resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    public String getName() {
        return resourceServer.getName();
    }

    @Override
    public int getAge() {
        return resourceServer.getAge();
    }

//    @Override
//    public void setUsersLimit(int bla) {
//        resourceServer.setUsersLimit(bla);
//    }
}
