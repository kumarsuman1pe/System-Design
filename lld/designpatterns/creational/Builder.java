package lld.designpatterns.creational;

class Builder {
    public static void main( String[] args ) {
        System.out.println( "Introducing Builder patterns!... " );
        Event event = new Event.EventBuilder().setId( 122L ).setName( "Suman" ).build();
        System.out.println( event.getName() );
    }
}

class Event {
    private Long id;
    private String name;

    public Event( EventBuilder eventBuilder ) {
        this.id = eventBuilder.id;
        this.name = eventBuilder.name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class EventBuilder {
        private Long id;
        private String name;

        public EventBuilder setId( Long id ) {
            this.id = id;
            return this;
        }

        public EventBuilder setName( String name ) {
            this.name = name;
            return this;
        }

        public Event build() {
            return new Event( this );
        }
    }
}