
public class VideoProcessor {

    // use Interface Segregation Principle (here fields rely on interfaces instead of composition or classes)
    private VideoEncoder encoder;
    private VideoDatabase database;
    private NotificationService service;

    // use Dependency Injection (constructor injection in this case)
    public VideoProcessor(VideoEncoder encoder, VideoDatabase database, NotificationService service) {
        this.encoder = encoder;
        this.database = database;
        this.service = service;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        service.notify(video.getUser());
    }

}

