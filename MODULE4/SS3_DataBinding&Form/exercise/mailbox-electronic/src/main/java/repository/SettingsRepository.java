package repository;

import java.util.List;

public interface SettingsRepository {
    List<String> getLanguage();
    List<String> getPageSize();
}
