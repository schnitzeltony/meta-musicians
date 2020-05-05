SUMMARY = "An old-school polyphonic sampler"
HOMEPAGE = "http://samplv1.sourceforge.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qtbase \
    jack \
    lv2 \
    liblo \
"

inherit qmake5_base autotools-brokensep pkgconfig gtk-icon-cache mime

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
    file://0001-no-Qt4-find-native-qt-build-tools-by-configure-options-auto.patch \
    file://0002-Avoid-stripping.patch \
"
PV = "0.9.14"
SRC_URI[md5sum] = "ef0a9f8cff08b9ace8ed15931237a01c"
SRC_URI[sha256sum] = "ac6bb56931c7bbc879b48b4af145fda494dc3aec1e18cabe1ee9db60354f6e5c"

EXTRA_OECONF = " \
    --with-qmake=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/qmake \
    --with-moc=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/moc \
    --with-uic=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/uic \
    --with-lupdate=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/lupdate \
    --with-lrelease=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/lrelease \
"

FILES_${PN} += " \
    ${datadir}/appdata \
    ${datadir}/mime \
    ${datadir}/metainfo \
    ${datadir}/icons \
    ${libdir}/lv2 \
"
