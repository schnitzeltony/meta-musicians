SUMMARY = "MuseScore is an open source and free music notation software"
HOMEPAGE = "https://musescore.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=ef318be74ef69ee7f919c9ebb45b6e21"

python() {
    if 'clang-layer' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-clang to be present due to qthelp requiring clang.')
}

DEPENDS = " \
    qttools-native \
    qttools \
    gzip-native \
    qtbase \
    qtdeclarative \
    qtsvg \
    qtwebengine \
    freetype \
    libsndfile1 \
    lame \
    fluidsynth \
    portaudio-v19 \
    portmidi \
    poppler \
    freetype \
"

SRC_URI = "git://github.com/musescore/MuseScore.git;branch=${PV}"
SRCREV = "465e7b6fe50973a24a75891e27575a8d2b962f6a"
S = "${WORKDIR}/git"
PV = "3.5.2"

inherit qmake5_base cmake_qt5 pkgconfig gtk-icon-cache mime mime-xdg features_check

OECMAKE_GENERATOR = "Unix Makefiles"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'pulseaudio', d)}"
PACKAGECONFIG[pulseaudio] = "-DBUILD_PULSEAUDIO=ON,-DBUILD_PULSEAUDIO=OFF,pulseaudio,pulseaudio-server"

EXTRA_OECMAKE = " \
    -DMUSESCORE_BUILD_CONFIG=release \
    -DBUILD_TELEMETRY_MODULE=OFF \
    -DBUILD_PCH=OFF \
    -DDOWNLOAD_SOUNDFONT=OFF \
    -DUSE_SYSTEM_FREETYPE=ON \
    -DUSE_SYSTEM_POPPLER=ON \
    -DCMAKE_SKIP_RPATH=TRUE \
"

# musescore's cmake uses qmake => we need a qt.conf and some hacks
OE_QMAKE_QMAKE = "echo"
QMAKE_PROFILES = "dummy.pro"

do_configure() {
    sed -i 's:${QT_QMAKE_EXECUTABLE} \"-query\":${QT_QMAKE_EXECUTABLE} \"-query\" \"-qtconf ${WORKDIR}/qt.conf\"':g ${S}/build/FindQt5.cmake
    qmake5_base_do_configure
    cmake_do_configure
    # cmake's find_library has never played nicely for us
    sed -i 's: ${libdir}/libpulse.so: ${STAGING_LIBDIR}/libpulse.so:g' ${B}/main/CMakeFiles/mscore.dir/build.make
}

do_install:append() {
    # they copy QtWebEngineProcess from libexe to bindir - tse tse
    rm -f ${D}${bindir}/QtWebEngineProcess
}

FILES:${PN} += " \
    ${datadir}/mscore-3.5 \
    ${datadir}/metainfo \
    ${datadir}/mime \
    ${libdir}/qt5 \
"

