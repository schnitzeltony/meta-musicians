# * yeah I know yocto does not want us to change this
# * we have to do this to avoid our qttools change break qt5-creator
PACKAGECONFIG_append = " ${@bb.utils.contains('BBFILE_COLLECTIONS', 'clang-layer', ' clang', '', d)}"

