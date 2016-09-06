package com.myschool.infra.filesystem.filefilter;

import java.io.File;
import java.io.FileFilter;

import com.myschool.file.constant.FileExtension;
import com.myschool.infra.filesystem.util.FileUtil;

/**
 * The Class MSExcelFileFilter.
 */
public class MSExcelFileFilter implements FileFilter {

    /* (non-Javadoc)
     * @see java.io.FileFilter#accept(java.io.File)
     */
    @Override
    public boolean accept(File file) {
        if (file != null && FileUtil.getExtension(file.getName().toLowerCase()).equals(FileExtension.XLS.getFileExtension())) {
            return true;
        }
        return false;
    }

}
