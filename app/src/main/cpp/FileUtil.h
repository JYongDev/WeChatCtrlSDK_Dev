
#ifndef CTRLSDK_FILEUTIL_H
#define CTRLSDK_FILEUTIL_H

#include <string>
#include <fstream>
#include "Log.h"

using namespace std;

class FileUtil {
public:
    static int getFileLength(string path);

    static char *readData(string path, string mode);

    static void writeData(string path, char *data);

    static char * readFile(string path);

    static bool isExist(string path);
};


#endif //CTRLSDK_FILEUTIL_H
