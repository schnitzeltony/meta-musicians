SUMMARY = "Qt based DJ software"
HOMEPAGE = "http://mixxx.org/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=827547320b68c9b65f19d8abd3d7a019"

inherit scons qmake5_paths pkgconfig features_check

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    qtbase \
    qtscript \
    qtsvg \
    qtxmlpatterns \
    qtx11extras \
    qttools-native \
    libusb1 \
    hidapi \
    upower \
    sqlite \
    libid3tag \
    taglib \
    libmad \
    faad2 \
    libmp4v2 \
    libogg \
    libvorbis \
    protobuf protobuf-native \
    fftw \
    portaudio-v19 \
    portmidi \
    chromaprint \
    rubberband \
    soundtouch \
    libglu \
    lilv \
    lame \
"
# causes segfault trying to find debug libs
#    gperftools

SRC_URI = " \
    git://github.com/mixxxdj/${BPN}.git \
    file://0001-do-not-check-for-known-machine-types.patch \
    file://0002-force-using-system-soundtouch.patch \
    file://0003-align-path-of-qt-build-tools-to-our-needs.patch \
    file://0004-Do-not-add-host-libdir-to-LDPATH-rpath.patch \
"
SRCREV = "59683489997e19d861a218e2e692cdbe52168869"
S = "${WORKDIR}/git"
PV = "2.2.4"

# qtbase is expected to be build for desktop GL. If there is qtbase with gles
# add opengles=1 to EXTRA_OESCONS but that currently disables code paths and
# wave displays remain empty
EXTRA_OESCONS += " \
    build=release \
    target=linux \
    machine=${TARGET_ARCH} \
    qtdir=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS} \
    shoutcast=0 \
    localecompare=0 \
    faad=1 \
"
#    perftools=1

# If we export in do_install only, mixxx is compiled twice
export LIBDIR="${libdir}"

# Have no idea why we need to create ui-headers...
do_compile_prepend() {
    for uifile in `find ${S} -name '*.ui'`; do
        genfile=`echo $uifile | sed -e 's:.ui:.h:' -e 's:/dlg:/ui_dlg:'`
        uic $uifile -o $genfile
    done
}

do_install_prepend() {
    sed -i 's:/etc/udev:${D}/etc/udev:g' ${S}/src/SConscript
}

FILES_${PN} += "${datadir}/appdata"

# was: 'probably-redundant RPATH /usr/lib' - not exactly a bad breaker. Looked
# into but could't find why this is thrown - so ignore for now.
INSANE_SKIP_${PN} = "useless-rpaths"
