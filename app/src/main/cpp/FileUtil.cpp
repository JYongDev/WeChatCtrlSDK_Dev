

#include "FileUtil.h"


int FileUtil::getFileLength(string path) {

    ifstream f(path.c_str(), ifstream::binary);

    if (f.is_open()) {

        ifstream::pos_type old = f.tellg();

        f.seekg(0, ifstream::beg);

        ifstream::pos_type start = f.tellg();

        f.seekg(0, ifstream::end);

        ifstream::pos_type end = f.tellg();

        f.seekg(old);

        f.close();
        return (int) (end - start);
    }
    return 0;
}

char *FileUtil::readData(string path, string mode) {

    int fileSize = FileUtil::getFileLength(path.c_str());
    LOGW(" fileSize %d", fileSize);
    char buff[fileSize];
    LOGW(" 1 ");
    FILE *file = fopen(path.c_str(), mode.c_str());
    LOGW(" 2 ");
    fgets(buff, fileSize, file);
    LOGW(" 3 ");
    fclose(file);
    LOGW(" 4 ");
    return buff;
}

void FileUtil::writeData(string path, char *data) {

    FILE *file = fopen(path.c_str(), "w");
    fputs(data, file);
    fclose(file);

}

char *FileUtil::readFile(string path) {

    ifstream ins(path.c_str(), ios::in);
    if (ins.is_open()) {

//        int len = FileUtil::getFileLength(path.c_str());

        char *buff;

        ins >> buff;

        return buff;
    }
    return NULL;
}

bool FileUtil::isExist(string path) {

    fstream file;
    file.open(path, ios::in);
    if (!file) {
        return false;
    } else {
        if (getFileLength(path) > 0) {
            return true;
        } else {
            return false;
        }
    }
}


