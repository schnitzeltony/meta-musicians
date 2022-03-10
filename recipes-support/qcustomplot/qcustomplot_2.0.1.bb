SUMMARY = "QCustomPlot is a Qt C++ widget for plotting and data visualization"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://GPL.txt;md5=d32239bcb673463ab874e80d47fae504"

# At the beginning we had to go backwards
PE = "1"

DEPENDS += " \
    qttools-native \
    qtbase \
"

SRC_URI = " \
    https://www.qcustomplot.com/release/${PV}/QCustomPlot-source.tar.gz;name=source;downloadfilename=QCustomPlot-source-${PV}.tar.gz \
    https://www.qcustomplot.com/release/${PV}/QCustomPlot-sharedlib.tar.gz;name=pro;downloadfilename=QCustomPlot-sharedlib-${PV}.tar.gz \
    file://qcustomplot-qt5.pc \
"
SRC_URI[source.md5sum] = "ba37869587f3073fb019ed45b085e972"
SRC_URI[source.sha256sum] = "574cee47def3251d080168a23428859214277cb9b6876bcdb9ce9d00b2403fe4"

SRC_URI[pro.md5sum] = "1023b2db6e84d6821d1f863b31f2cb06"
SRC_URI[pro.sha256sum] = "cca0847dad29beff57b36e21efd1a0c40f74781f4648fb0921fb269d4f61d583"

S = "${WORKDIR}/qcustomplot-source"

inherit qmake5

do_configure:prepend() {
    cp ${WORKDIR}/qcustomplot-sharedlib/sharedlib-compilation/sharedlib-compilation.pro ${S}
    sed -i 's:../../qcustomplot:qcustomplot:g' ${S}/sharedlib-compilation.pro
}

do_install() {
    install -d ${D}${libdir}
    cp -d ${B}/libqcustomplot.so* ${D}${libdir}

    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${WORKDIR}/qcustomplot-qt5.pc ${D}${libdir}/pkgconfig/
    sed -i \
        -e 's:%libdir%:${libdir}:g' \
        -e 's:%includedir%:${includedir}:g' \
        ${D}${libdir}/pkgconfig/qcustomplot-qt5.pc

    install -d ${D}${includedir}
    install -m 0644 ${S}/qcustomplot.h ${D}${includedir}/
}

