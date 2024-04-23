#include <iostream>

int main()
{
    // Outer loop
    for (int i = 1; i <= 3; ++i)
    {
        std::cout << "Outer loop iteration " << i << ":" << std::endl;

        // Inner loop
        for (int j = 1; j <= 2; ++j)
        {
            if (j == 2)
            {
                break;
            }
            std::cout << "    Inner loop iteration " << j << std::endl;
        }
        std::cout << "    j is not null"  << std::endl;

        std::cout << std::endl;
    }

    return 0;
}
