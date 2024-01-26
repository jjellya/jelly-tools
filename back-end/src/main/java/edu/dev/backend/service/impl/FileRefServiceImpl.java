package edu.dev.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.dev.backend.dao.FileRefMapper;
import edu.dev.backend.entity.FileRef;
import edu.dev.backend.service.FileRefService;
import org.springframework.stereotype.Service;

/**
 * Create By  @林俊杰
 * 2022/3/15 22:40
 *
 * @version 1.0
 */
@Service
public class FileRefServiceImpl extends ServiceImpl<FileRefMapper, FileRef> implements FileRefService {
}
