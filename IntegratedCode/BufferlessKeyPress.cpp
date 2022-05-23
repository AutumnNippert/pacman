#include <iostream>
#if defined(__linux__) || defined(__APPLE__)
    #include <ncurses.h>
#elif defined(_WIN32)
    #include <conio.h>
#endif
// Compile using g++ -o BufferlessKeyPress BufferlessKeyPress.cpp -lncurses

int main()
{
    std::cout << "Press any key to continue..." << std::endl;
    #if defined(__linux__) || defined(__APPLE__)
        initscr();
        noecho();
        //cbreak();
        keypad(stdscr, TRUE);
    #elif defined(_WIN32)
        _setmode(_fileno(stdin), _O_U16TEXT);
    #endif

    while (1)
    {
        char c;
        c = getch();
        if (c != ERR)
        {
            return c;
        }
        std::cout << c;
    }
    return 1;
}