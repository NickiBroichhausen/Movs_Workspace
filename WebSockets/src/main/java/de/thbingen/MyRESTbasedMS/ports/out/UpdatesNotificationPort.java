package de.thbingen.MyRESTbasedMS.ports.out;

import de.thbingen.MyRESTbasedMS.service.model.User;

public interface UpdatesNotificationPort {

  void notify(User user, Operation operation);

}
